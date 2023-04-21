import { useAppDispatch } from "../../app/hooks"

interface SeanseItem {
  id: number
  time: string
  room: string
  seanseType: string
  onPress: (id: number) => void
}

export default function SeanseItem({ id, time, room, seanseType, onPress }: SeanseItem) {

  //TODO: привязать id к клику на сеанс и фетчить данные из модального

  const dispatch = useAppDispatch()

  return (
    <div className="seanse-item__container" onClick={() => onPress(id)}>
      <div className="seanse-item__main-description">
        <div className="seanse-item__time">
          {time}
        </div>
        <div className="seanse-item__seanse-type">
          {seanseType}
        </div>
      </div>
      <div className="seanse-item__room">
        Зал {room}
      </div>
    </div>
  )
}
