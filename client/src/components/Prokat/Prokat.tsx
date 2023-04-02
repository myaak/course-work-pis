import { useState } from 'react' 
import ProkatFilmItem from "./ProkatFilmItem";
import './Prokat.scss'


  const filmItem = {
    filmName: 'Крутые крысы',
    filmGenres: ['Ekshn', 'Fantastica'],
    filmSeanes: ['Today 11.30']
  }

export default function Prokat() {

  const [films, setFilms] = useState<any>([
    filmItem, filmItem, filmItem
  ])


  return (
      <div className="prokat__container">
        <h1 style={{
          textAlign: 'center',
          marginBottom: '1rem'
        }}>Фильмы в прокате</h1>
      <ul className="prokat__films-list">
        {films.map((item: any, index: number) => (
          <ProkatFilmItem 
            key={index}
            filmName={item.filmName}
            filmGenres={item.filmGenres}
          />
        ))
      }
      </ul>
      </div>
  )
}
