import { useState } from 'react'
import { Link } from 'react-router-dom'
import './header.scss'

export default function Header() {

  const [menu, showMenu] = useState<boolean>(false)
  return (
    <header className="header">
      <nav className="nav container">
        <a className="nav__logo" href="#">
          PJ Cinema
        </a>

        <div className={menu ? "nav__menu show-menu" :
          "nav__menu"}>
          <ul className="nav__list grid">
            <li className="nav__item">
              <Link to="/" className="nav__link">
                <i className="uil uil-estate nav__icon"></i>
                Главная
              </Link>
            </li>

            <li className="nav__item">
              <Link to="/prokat" className="nav__link">
                <i className="uil uil-user nav__icon"></i>
                Прокат
              </Link>
            </li>

            <li className="nav__item">
              <Link to="/seanses" className="nav__link">
                <i className="uil uil-message nav__icon"></i>
                Сеансы
              </Link>
            </li>

            <li className="nav__item">
              <Link to="/mytickets" className="nav__link">
                <i className="uil uil-message nav__icon"></i>
                Мои билеты
              </Link>
            </li>

            <li className="nav__item">
              <Link to="/profile" className="nav__link">
                <i className="uil uil-message nav__icon"></i>
                Профиль
              </Link>
            </li>
          </ul>

          <i className="uil uil-times nav__close"
            onClick={() => showMenu(prev => !prev)}>

          </i>
        </div>

        <div
          className="nav__toggle"
          onClick={
            () => showMenu(prev => !prev)
          }>

          <i className="uil uil-bars"></i>
        </div>



      </nav>
    </header>
  )
}
