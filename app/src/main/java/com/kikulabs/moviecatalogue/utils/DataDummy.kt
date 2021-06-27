package com.kikulabs.moviecatalogue.utils

import com.kikulabs.moviecatalogue.data.source.local.entity.MovieEntity
import com.kikulabs.moviecatalogue.data.source.local.entity.TvShowEntity
import com.kikulabs.moviecatalogue.data.source.remote.response.movie.MovieDetailResponse
import com.kikulabs.moviecatalogue.data.source.remote.response.movie.MovieList
import com.kikulabs.moviecatalogue.data.source.remote.response.tv.TvShowDetailResponse
import com.kikulabs.moviecatalogue.data.source.remote.response.tv.TvShowList

object DataDummy {
    private val dateChange = DateChange()

    fun getMovies(): List<MovieEntity> {
        return listOf(
            MovieEntity(
                632357,
                "The Unholy",
                "/6wxfWZxQcuv2QgxIQKj0eYTdKTv.jpg",
                "2021-03-31",
                7.1,
                "en",
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                false
            ),
            MovieEntity(
                823855,
                "I Am All Girls",
                "/m6bUeV4mczG3z2YXXr5XDKPsQzv.jpg",
                "2021-05-14",
                7.0,
                "en",
                "A special crimes investigator forms an unlikely bond with a serial killer to bring down a global child sex trafficking syndicate.",
                false
            ),
            MovieEntity(
                460465,
                "Mortal Kombat",
                "/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                "2021-04-07",
                7.6,
                "en",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                false
            )
        )
    }

    fun getDetailMovie(): MovieEntity {
        return MovieEntity(
            460465,
            "Mortal Kombat",
            "/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
            dateChange.changeFormatDate("2021-04-07").toString(),
            7.6,
            "en",
            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
            false
        )
    }

    fun getTvShows(): List<TvShowEntity> {
        return listOf(
            TvShowEntity(
                63174,
                "Lucifer",
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "2016-01-25",
                8.5,
                "en",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                false
            ),
            TvShowEntity(
                60735,
                "The Flash",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "2014-10-07",
                7.7,
                "en",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                false
            ),
            TvShowEntity(
                71712,
                "The Good Doctor",
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "2017-09-25",
                8.6,
                "en",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                false
            )
        )
    }

    fun getDetailTvShow(): TvShowEntity {
        return TvShowEntity(
            63174,
            "Lucifer",
            "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
            dateChange.changeFormatDate("2016-01-25").toString(),
            8.5,
            "en",
            "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
            false
        )
    }

    fun getRemoteMovies(): List<MovieList> {
        return listOf(
            MovieList(
                overview = "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                originalLanguage = "en",
                originalTitle = "The Unholy",
                video = false,
                title = "The Unholy",
                posterPath = "/6wxfWZxQcuv2QgxIQKj0eYTdKTv.jpg",
                backdropPath = "/wwFBRyekDcKXJwP0mImRJjAnudL.jpg",
                releaseDate = "2021-03-31",
                popularity = 4734.184,
                voteAverage = 7.1,
                id = 632357,
                adult = false,
                voteCount = 696
            ),
            MovieList(
                overview = "A special crimes investigator forms an unlikely bond with a serial killer to bring down a global child sex trafficking syndicate.",
                originalLanguage = "en",
                originalTitle = "I Am All Girls",
                video = false,
                title = "I Am All Girls",
                posterPath = "/m6bUeV4mczG3z2YXXr5XDKPsQzv.jpg",
                backdropPath = "/yyWNPhP1HR4BTLErHcZwIUsMBvA.jpg",
                releaseDate = "2021-05-14",
                popularity = 1966.057,
                voteAverage = 7.0,
                id = 823855,
                adult = false,
                voteCount = 85
            ),
            MovieList(
                overview = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                originalLanguage = "en",
                originalTitle = "Mortal Kombat",
                video = false,
                title = "Mortal Kombat",
                posterPath = "/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                backdropPath = "/mPBI506o7gITnjoSkcyPneK9s8n.jpg",
                releaseDate = "2021-04-07",
                popularity = 1959.572,
                voteAverage = 7.6,
                id = 460465,
                adult = false,
                voteCount = 2776
            ),

            )
    }

    fun getRemoteDetailMovie(): MovieDetailResponse {
        return MovieDetailResponse(
            overview = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
            originalLanguage = "en",
            originalTitle = "Mortal Kombat",
            imdbId = "tt0293429",
            runtime = 110,
            video = false,
            title = "Mortal Kombat",
            posterPath = "/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
            backdropPath = "/mPBI506o7gITnjoSkcyPneK9s8n.jpg",
            revenue = 76706000,
            releaseDate = "2021-04-07",
            popularity = 1959.572,
            voteAverage = 7.6,
            tagline = "Get over here.",
            id = 460465,
            adult = false,
            voteCount = 2777,
            budget = 20000000,
            homepage = "https://www.mortalkombatmovie.net",
            status = "Released"
        )
    }

    fun getRemoteTvShows(): List<TvShowList> {
        return listOf(
            TvShowList(
                backdropPath = "/h48Dpb7ljv8WQvVdyFWVLz64h4G.jpg",
                firstAirDate = "2016-01-25",
                overview = "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                originalLanguage = "en",
                originalName = "Lucifer",
                popularity = 2154.69,
                voteAverage = 8.5,
                name = "Lucifer",
                id = 63174,
                voteCount = 8926,
                posterPath = "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg"
            ),
            TvShowList(
                backdropPath = "/9Jmd1OumCjaXDkpllbSGi2EpJvl.jpg",
                firstAirDate = "2014-10-07",
                overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                originalLanguage = "en",
                originalName = "The Flash",
                popularity = 1028.647,
                voteAverage = 7.7,
                name = "The Flash",
                id = 60735,
                voteCount = 7723,
                posterPath = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"
            ),
            TvShowList(
                backdropPath = "/iDbIEpCM9nhoayUDTwqFL1iVwzb.jpg",
                firstAirDate = "2017-09-25",
                overview = "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                originalLanguage = "en",
                originalName = "The Good Doctor",
                popularity = 937.469,
                voteAverage = 8.6,
                name = "The Good Doctor",
                id = 71712,
                voteCount = 8514,
                posterPath = "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg"
            )
        )
    }

    fun getRemoteDetailTvShow(): TvShowDetailResponse {
        return TvShowDetailResponse(
            firstAirDate = "2016-01-25",
            overview = "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
            originalLanguage = "en",
            numberOfEpisodes = 93,
            type = "Scripted",
            posterPath = "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
            backdropPath = "/h48Dpb7ljv8WQvVdyFWVLz64h4G.jpg",
            originalName = "Lucifer",
            popularity = 2154.69,
            voteAverage = 8.5,
            name = "Lucifer",
            tagline = "It's good to be bad.",
            id = 63174,
            numberOfSeasons = 6,
            inProduction = true,
            lastAirDate = "2021-05-28",
            voteCount = 8930,
            homepage = "https://www.netflix.com/title/80057918",
            status = "Returning Series"
        )
    }
}