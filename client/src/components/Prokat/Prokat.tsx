import { useState } from 'react'
import ProkatFilmItem from "./ProkatFilmItem";
import './Prokat.scss'
import { useAppSelector } from '../../app/hooks';

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
            filmName={item.title}
            filmGenres={item.genres}
            filmDesc={item.description}
          />
        ))
        }
      </ul>
    </div>
  )
}

