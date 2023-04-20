import './Places.scss'
import PlacesRow from './PlacesRow'
import {places} from './places'



export default function Places() {


  const generatePlaces = (places: any) => {
    console.log(places.length)
    let modifiedPlaces:any = []
    let count = 0
    let rowPlaces: any = []
    for (let i = 0; i < places.length + 1; ++i) {

      if(count === 5) {

        const placesObject = {
          row: modifiedPlaces.length === 0 ? 1 : modifiedPlaces[modifiedPlaces.length - 1].row + 1,
          rowPlaces: rowPlaces 
        }

        modifiedPlaces.push(placesObject)
        count = 0
        rowPlaces = []

      }

      rowPlaces.push(places[i])

      count++
    }

    return modifiedPlaces
  }

  const modifiedPlaces = generatePlaces(places)
  console.log(modifiedPlaces)

  return (
    <div className="places__container">
      <div className="places__content">
        <div className="places__room">
          <div className="places__room__screen">
            Экран
          </div>
          <div className="places__room__web">
            {modifiedPlaces.map((item: any, index:number) => (
              <PlacesRow key={index} places={item.rowPlaces}/>
            ))
            }
          </div>
        </div>
        <div className="places__info"></div>
      </div>
    </div>
  )
}
