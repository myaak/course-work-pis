import { useEffect, useState } from 'react'
import { useAppDispatch, useAppSelector } from '../../app/hooks'
import { IPlace } from '../../models/IPlace'
import { addPlace } from '../../store/reducers/placesReducer'

interface PlacesRow {
  places: Array<any>
}

export default function PlacesRow({ places }: PlacesRow) {

  const dispatch = useAppDispatch()

  const selectedPlaces = useAppSelector(state => state.placesSlice.currentPlaces)

  const ifPlaceAlreadyChosen = (placeToCheck: IPlace) => {
    if (selectedPlaces.filter((place: IPlace) => place.id === placeToCheck.id).length === 0) {
      return false
    }

    return true
  }

  const itemClick = (newPlace: IPlace) => {

    if (ifPlaceAlreadyChosen(newPlace)) {
      return
    }

    if (newPlace.bought) {
      return
    }

    dispatch(addPlace(newPlace))
  }

  useEffect(() => {
  }, [selectedPlaces])

  return (
    <div className="places__room__row">
      {places.map((item: any, index: number) => (
        <div className={`places__room__place ${item.bought ? "disabled" : ""} 
            ${selectedPlaces.filter((place: IPlace) => item.id === place.id).length !== 0 ? "selected" : ""}`} key={index}
          onClick={() => itemClick(item)}
        >
          {item.number}
        </div>
      ))
      }
    </div>
  )
}
