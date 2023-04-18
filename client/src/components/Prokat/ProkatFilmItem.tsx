import GenreItem from "./GenreItem"

interface FilmItemProps {
  filmName: string
  filmGenres: Array<string>
  filmSeanses?: Array<string>
  filmDesc: string
}


export default function ProkatFilmItem({ filmName, filmGenres, filmSeanses, filmDesc }: FilmItemProps) {
  return (
    <div className="prokat-film-item__container">
      <div className="prokat-film-item__content">
        <img src={'film1.jpg'} alt="13" />
        <div className="prokat-film-item__description">
          <div className="prokat-film-item__name">
            {filmName}
          </div>
          <div className="prokat-film-item__genres">
            {filmGenres.map((item: any, index: number) => (
              <GenreItem key={index} genreName={item.title}/>
            ))
            }
          </div>
          <div className="prokat-film-item__seanses">
            Seanses
          </div>

          <div className="prokat-film-item__desc">
            {filmDesc}
          </div>
        </div>
      </div>

    </div>
  )
}
