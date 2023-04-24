import './Places.scss'
import PlacesRow from './PlacesRow'
import { places } from './places'
import { generatePlaces } from '../../generatePlaces'
import { useAppSelector } from '../../app/hooks'
import { useEffect } from 'react'
import axios from 'axios'
import { serverUrl } from '../../info'


export default function Places() {

  //const currentSession = useAppSelector(state => state.currentSession)

  const modifiedPlaces = generatePlaces(places)


  const getCurrentSession = async () => {
    //const response = await axios.get(`${serverUrl}/get/session/${currenSession.id}`)
    //dispatch(updateCurrentSession(response.data))
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
        </div>
      </div>
    </div>
  )
}
