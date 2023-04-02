import './styles/main.scss'
import { AppRouter, Footer, Header } from './components'
import { BrowserRouter } from 'react-router-dom'

function App() {

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
        </footer>
      </div>
    </BrowserRouter>

  )
}

export default App
