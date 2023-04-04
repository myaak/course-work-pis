import { useState } from 'react' 
import ProkatFilmItem from "./ProkatFilmItem";
import './Prokat.scss'
import { useAppSelector } from '../../app/hooks';


  const filmItem = {
  }

export default function Prokat() {

  const films = useAppSelector(state => state.filmsList.films)

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
