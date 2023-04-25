import './Places.scss'
import PlacesRow from './PlacesRow'
import { places } from './places'
import { generatePlaces } from '../../generatePlaces'
import { useAppDispatch, useAppSelector } from '../../app/hooks'
import { useEffect } from 'react'
import axios from 'axios'
import { serverUrl } from '../../info'
import { IPlace } from '../../models/IPlace'
import { addTicket } from '../../store/reducers/userReducer'
import { changeModalState } from '../../store/reducers/modalReducer'


export default function Places() {

  //const currentSession = useAppSelector(state => state.currentSession)
  const dispatch = useAppDispatch()

  const modifiedPlaces = generatePlaces(places)
  const selectedPlaces = useAppSelector(state => state.placesSlice.currentPlaces)


  const getCurrentSession = async () => {
    //const response = await axios.get(`${serverUrl}/get/session/${currenSession.id}`)
    //dispatch(updateCurrentSession(response.data))
  }

  const addNewTicket = () => {
  //id film time place price 
    
    const newTicket = {
      id: 1,
      film: "newFilm",
      time: "10.30",
      place: selectedPlaces,
    }

    dispatch(addTicket(newTicket))
    dispatch(changeModalState(false))

  }


  useEffect(() => {
    getCurrentSession()
  }, [])

  return (
    <div className="places__container">
      <div className="places__content">
        <div className="places__room">
          <div className="places__room__screen">
            Экран
          </div>
          <div className="places__room__web">
            {modifiedPlaces.map((item: any, index: number) => (
              <PlacesRow key={index} places={item.rowPlaces} />
            ))
            }
          </div>
        </div>
        <div className="places__info">
          <div className="places__info__title">
            currentSession.title
          </div>
          <div className="places__info__session-info">
            currentSession.time
          </div>
          <div>
            <div>Выбранные места</div>
            <div style={{
              display: 'flex',
              gap: '1rem'
            }}>
              {selectedPlaces.length > 0 &&
                selectedPlaces.map((item: IPlace, index: number) => (
                  <span key={index}>{item.number}</span>
                ))
              }
            </div>
          </div>
          {
            selectedPlaces.length > 0 &&
            <button onClick={addNewTicket}>Купить</button>
          }
        </div>
      </div>
    </div>
  )
}
