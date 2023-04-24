import './styles/main.scss'
import { AppRouter, Footer, Header } from './components'
import { BrowserRouter } from 'react-router-dom'
import { useAppDispatch, useAppSelector } from './app/hooks'
import Places from './components/Places/Places'

function App() {

  const openedSeanseModal = useAppSelector(state => state.seanseModal.opened)
  const dispatch = useAppDispatch()

  return (
    <BrowserRouter>
      <div className="App">
        <header>
          <Header />
        </header>
        <main>
          //{openedSeanseModal && <Places />}
          <Places />
          <AppRouter />
        </main>
        <footer>
          <Footer />
        </footer>
      </div>
    </BrowserRouter>

  )
}

export default App
