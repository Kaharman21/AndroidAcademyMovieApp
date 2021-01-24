package com.pavlodar.androidacademymovieapp.movies_details

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.pavlodar.androidacademymovieapp.R
import com.pavlodar.androidacademymovieapp.common.presentation.views.BaseFragment
import com.pavlodar.androidacademymovieapp.data.loadMovies
import com.pavlodar.androidacademymovieapp.movies_details.presentation.view_model.MoviesDetailsViewModel
import com.pavlodar.androidacademymovieapp.movies_details.presentation.view_model.MoviesDetailsViewModelFactory
import com.pavlodar.androidacademymovieapp.movies_details.presentation.views.MoviesDetailsAdapter
import com.pavlodar.androidacademymovieapp.movies_list.data.models.Actor
import com.pavlodar.androidacademymovieapp.movies_list.data.models.Movie
import java.lang.StringBuilder

class FragmentMoviesDetails() : BaseFragment(R.layout.fragment_movies_details) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var moviePoster: ImageView
    private lateinit var favoriteImage: ImageView
    private lateinit var minimumAge: TextView
    private lateinit var movieTitle: TextView
    private lateinit var movieGenre: TextView
    private lateinit var rating: RatingBar
    private lateinit var storylineTitle: TextView
    private lateinit var storylineText: TextView
    private lateinit var backTextView: TextView

    private var listener: OnBackPressedInterface? = null
    private var adapter: MoviesDetailsAdapter = MoviesDetailsAdapter()

    private val viewModel: MoviesDetailsViewModel by viewModels {
        val movie: Movie = arguments?.getParcelable(MOVIE_ARGUMENT)!!
        MoviesDetailsViewModelFactory(movie)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnBackPressedInterface){
            listener = context
        }
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        initViewModel()
        setupListeners()
    }

    private fun initViewModel() {
        viewModel.getMovieData().observe(this.viewLifecycleOwner, ::handleData)
    }

    private fun handleData(movieData: Movie) {
        moviePoster.load(movieData.imageUrl){
            placeholder(R.drawable.ic_favorite_filed)
        }
        minimumAge.text = movieData.pgAge.toString()
        movieTitle.text = movieData.title
        rating.rating = movieData.rating.toFloat()
        storylineText.text = movieData.storyLine

        handleFavorite(movieData)

        var st = StringBuilder()

        for (n in movieData.genres.indices) {
            st.append(movieData.genres[n].name)
            if (n<movieData.genres.size-1){
                st.append(", ")
            }
        }
        movieGenre.text = st

        adapter.setData(movieData.actors)
    }

    private fun handleFavorite(movieData: Movie){
        if (movieData.isLiked) {
            favoriteImage.load(R.drawable.ic_favorite_filed)
        } else {
            favoriteImage.load(R.drawable.ic_favorite_empty)
        }
    }

    private fun initViews(view: View) {
        moviePoster = view.findViewById(R.id.fragment_movies_details_background_image)
        favoriteImage = view.findViewById(R.id.fragment_movies_details_favorite)
        minimumAge = view.findViewById(R.id.fragment_movies_details_age_limitation)
        movieTitle = view.findViewById(R.id.fragment_movies_details_movie_title)
        movieGenre = view.findViewById(R.id.fragment_movies_details_movie_genre)
        rating = view.findViewById(R.id.fragment_movies_details_rating)
        storylineTitle = view.findViewById(R.id.fragment_movies_details_storyline_title)
        storylineText = view.findViewById(R.id.fragment_movies_details_storyline_text)
        backTextView = view.findViewById(R.id.fragment_movies_details_back_text_view)

        recyclerView = view.findViewById(R.id.fragment_movies_details_recycler_view)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
    }

    private fun setupListeners() {
        backTextView.setOnClickListener {
            listener?.onBackPressedAction()
        }
    }

    companion object {
        private const val MOVIE_ARGUMENT = "MOVIE_ARGUMENT"

        fun newInstance(movie: Movie): FragmentMoviesDetails {
            val args = Bundle()
            args.putParcelable(MOVIE_ARGUMENT, movie)

            val fragment = FragmentMoviesDetails()
            fragment.arguments = args
            return fragment
        }
    }
}

interface OnBackPressedInterface{
    fun onBackPressedAction()
}