import GenreItem from "./GenreItem"

interface FilmItemProps {
  filmName: string
  filmGenres: Array<string>
  filmSeanses?: Array<string>
}


export default function ProkatFilmItem({filmName, filmGenres}: FilmItemProps) {
  return (
    <div className="prokat-film-item__container">
      <div className="prokat-film-item__content">
          <img src={'film1.jpg'} alt="13"/>
        <div className="prokat-film-item__description">
          <div className="prokat-film-item__name">
            {filmName}
          </div>
          <div className="prokat-film-item__genres">
            {filmGenres.map((item: string, index: number) => (
              <GenreItem key={index} genreName={item}/>
            ))
            }
          </div>
          <div className="prokat-film-item__seanses">
            Seanses
          </div>
        </div>
      </div>

    </div>
  )
}
