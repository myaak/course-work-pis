import { useState, useEffect } from 'react'
import ProkatFilmItem from "./ProkatFilmItem";
import './Prokat.scss'
import { useAppDispatch, useAppSelector } from '../../app/hooks';
import { fetchFilms } from '../../store/ActionCreators/FilmsAction';

export default function Prokat() {

  const films = useAppSelector(state => state.filmsList.films)
  const dispatch = useAppDispatch()

  useEffect(() => {
    dispatch(fetchFilms())

  }, [])

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
            coverId={item.cover.id}
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

