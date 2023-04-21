import axios from "axios"
import { useState } from "react"
import { useAppDispatch, useAppSelector } from "../../app/hooks"
import { serverUrl } from "../../info"
import { seanseModal } from "../../store/reducers/modalReducer"
import GenreItem from "./GenreItem"
import SeanseItem from "./SeanseItem"

interface FilmItemProps {
  coverId: number
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




export default function ProkatFilmItem({ coverId, filmName, filmGenres, filmSeanses, filmDesc }: FilmItemProps) {

  const [cover, setCover] = useState<any>()

  const openedSeanseModal = useAppSelector(state => state.seanseModal.opened)
  const { changeModalState } = seanseModal.actions
  const dispatch = useAppDispatch()

  const onSeansePress = (seanseId: number) => {
    dispatch(changeModalState(!openedSeanseModal))
    console.log('seanse',seanseId)
  }

  return (
    <div className="prokat-film-item__container">
      <div className="prokat-film-item__content">
        <img src={`${serverUrl}/get/cover/${coverId}`} alt="Ой все сломалось" />
        <div className="prokat-film-item__description">
          <div className="prokat-film-item__name">
            {filmName}
          </div>
          <div className="prokat-film-item__genres">
            {filmGenres.map((item: any, index: number) => (
              <GenreItem key={index} genreName={item.title} />
            ))
            }
          </div>
        </div>
        <span className="prokat-film-item__title">Сеансы</span>
        <div className="prokat-film-item__seanses">
          {seanses.map((item: any, index: number) =>
          (
            <SeanseItem key={index}
              id={1}
              time={item.time}
              room={item.room}
              seanseType={item.seanseType}
              onPress={(id) => {onSeansePress(id)}}
            />
          ))}
        </div>
      </div>

    </div>
  )
}

/*
* ID on press поменять на айди который будет для сеанса
*/
