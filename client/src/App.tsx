import './styles/main.scss'
import { AppRouter, Footer, Header } from './components'
import { BrowserRouter } from 'react-router-dom'
import { serverUrl } from './info'
import { fetchFilms } from './store/ActionCreators/FilmsAction'
import { useAppDispatch, useAppSelector } from './app/hooks'
import Places from './components/Places/Places'

function App() {

  const films = useAppSelector(state => state.filmsList.films)

  const dispatch = useAppDispatch()

  const postFilm = async () => {
    await fetch(`${serverUrl}/post/movie`, {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        title: "newMovie3",
        durationInMinutes: "123",
        coverURL: './',
        description: "Cool test movie",
        genres: []
      })
    }).catch((err) => {
      console.log(err)
      return
    })
  }

  const getFilms = async () => {
    dispatch(fetchFilms())

    console.log(films)
  }

  return (
    <BrowserRouter>
      <div className="App">
        <header>
          <Header />
        </header>
        <main>
          <AppRouter />
        </main>
        <footer>
          <Footer />
          <button onClick={postFilm}>postFilmTest</button>
          <button onClick={getFilms}>getFilms</button>
        </footer>
      </div>
    </BrowserRouter>

  )
}

export default App
