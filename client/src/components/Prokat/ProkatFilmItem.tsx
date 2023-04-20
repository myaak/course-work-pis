import GenreItem from "./GenreItem"
import SeanseItem from "./SeanseItem"

interface FilmItemProps {
  filmName: string
  filmGenres: Array<string>
  filmSeanses?: Array<string>
  filmDesc: string
}

const seanses = [
  {
  time: "12.30",
  room: "Олег",
  seanseType: "2D"
  },
  {
    time: "14.30",
  room: "Капр",
  seanseType: "2D"
  },
  {
  time: "17.30",
  room: "Капр",
  seanseType: "2D"
  }
]


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
            genres
          </div>
        </div>
        <span className="prokat-film-item__title">Сеансы</span>
        <div className="prokat-film-item__seanses">
            {seanses.map((item: any, index: number) => 
            (
              <SeanseItem key={index}
                time={item.time}
                room={item.room}
                seanseType={item.seanseType}
              />
            ))}
        </div>
      </div>

    </div>
  )
}

/*
            {filmGenres.map((item: any, index: number) => (
              <GenreItem key={index} genreName={item.title} />
            ))
            }
*/
