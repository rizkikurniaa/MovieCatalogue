package com.kikulabs.moviecatalogue.utils

import com.kikulabs.moviecatalogue.R
import com.kikulabs.moviecatalogue.data.DataEntity

object DataDummy {

    fun generateDummyMovies(): List<DataEntity> {

        val movies = ArrayList<DataEntity>()

        movies.add(
            DataEntity(
                "m1",
                "Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train (2020)",
                R.drawable.poster_kimetsu,
                "October 16, 2020",
                "8.3",
                "Japanese",
                "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!"
            )
        )
        movies.add(
            DataEntity(
                "m2",
                "A Star Is Born (2018)",
                R.drawable.poster_a_start_is_born,
                "October 5, 2018",
                "7.5",
                "English",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons."
            )
        )
        movies.add(
            DataEntity(
                "m3",
                "How to Train Your Dragon: The Hidden World (2019)",
                R.drawable.poster_how_to_train,
                "January 3, 2019",
                "7.8",
                "English",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind."
            )
        )
        movies.add(
            DataEntity(
                "m4",
                "Avengers: Infinity War (2018)",
                R.drawable.poster_infinity_war,
                "April 25, 2018",
                "8.3",
                "English",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain."
            )
        )
        movies.add(
            DataEntity(
                "m5",
                "Overlord (2018)",
                R.drawable.poster_overlord,
                "November 1, 2018",
                "6.7",
                "English",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else."
            )
        )
        movies.add(
            DataEntity(
                "m6",
                "Robin Hood (2018)",
                R.drawable.poster_robin_hood,
                "November 21, 2018",
                "5.9",
                "English",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown."
            )
        )
        movies.add(
            DataEntity(
                "m7",
                "Serenity (2019)",
                R.drawable.poster_serenity,
                "January 24, 2019",
                "5.4",
                "English",
                "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help."
            )
        )
        movies.add(
            DataEntity(
                "m8",
                "Alita: Battle Angel (2019)",
                R.drawable.poster_alita,
                "January 31, 2019",
                "7.2",
                "English",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past."
            )
        )
        movies.add(
            DataEntity(
                "m9",
                "Cold Pursuit (2019)",
                R.drawable.poster_cold_persuit,
                "February 7, 2019",
                "5.7",
                "English",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution."
            )
        )
        movies.add(
            DataEntity(
                "m10",
                "Creed II (2018)",
                R.drawable.poster_creed,
                "November 21, 2018",
                "6.9",
                "English",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life."
            )
        )


        return movies
    }

    fun generateDummyTvShows(): List<DataEntity> {
        val tvShows = ArrayList<DataEntity>()

        tvShows.add(
            DataEntity(
                "tv1",
                "Arrow (2012)",
                R.drawable.poster_arrow,
                "October 10, 2012",
                "6.6",
                "English",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow."
            )
        )
        tvShows.add(
            DataEntity(
                "tv2",
                "Gotham (2014)",
                R.drawable.poster_gotham,
                "September 22, 2014",
                "7.5",
                "English",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?"
            )
        )
        tvShows.add(
            DataEntity(
                "tv3",
                "Grey's Anatomy (2005)",
                R.drawable.poster_grey_anatomy,
                "March 27, 2005",
                "8.2",
                "English",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital."
            )
        )
        tvShows.add(
            DataEntity(
                "tv4",
                "Hanna (2019)",
                R.drawable.poster_hanna,
                "March 28, 2019",
                "7.5",
                "English",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film."
            )
        )
        tvShows.add(
            DataEntity(
                "tv5",
                "Marvel's Iron Fist (2017)",
                R.drawable.poster_iron_fist,
                "March 17, 2017",
                "6.6",
                "English",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny."
            )
        )
        tvShows.add(
            DataEntity(
                "tv6",
                "Naruto Shippūden (2007)",
                R.drawable.poster_naruto_shipudden,
                "February 15, 2007",
                "8.6",
                "Japanese",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki."
            )
        )
        tvShows.add(
            DataEntity(
                "tv7",
                "Shameless (2011)",
                R.drawable.poster_shameless,
                "January 9, 2011",
                "8.0",
                "English",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are."
            )
        )
        tvShows.add(
            DataEntity(
                "tv8",
                "Supergirl (2015)",
                R.drawable.poster_supergirl,
                "October 26, 2015",
                "7.3",
                "English",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism."
            )
        )
        tvShows.add(
            DataEntity(
                "tv9",
                "Supernatural (2005)",
                R.drawable.poster_supernatural,
                "September 13, 2005",
                "8.2",
                "English",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way."
            )
        )
        tvShows.add(
            DataEntity(
                "tv10",
                "The Simpsons (1989)",
                R.drawable.poster_the_simpson,
                "December 17, 1989",
                "7.8",
                "English",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general."
            )
        )

        return tvShows
    }
}