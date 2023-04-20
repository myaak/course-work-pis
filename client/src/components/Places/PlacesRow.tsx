interface Place {
  id: number,
  number: number,
  bought: boolean
}

interface PlacesRow {
  places: Array<any>
}

export default function PlacesRow({places}: PlacesRow) {
  return (
    <div className="places__room__row">
      {places.map((item:any, index: number) => (
      <div className={`places__room__place ${item.bought ? "disabled" : ""}`} key={index}>
        {item.number}
      </div>
      ))

    }
    </div >
  )
}
