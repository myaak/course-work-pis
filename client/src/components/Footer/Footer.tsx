import './footer.scss'


export default function Footer() {
  const _links = ["О нас", "Контакты", "Адрес"]
  return (
    <footer className="footer">
      <div className="footer__container container">
        <h1 className="footer__title">PJP Cinema</h1>

        <ul className="footer__list">
          {_links.map((item: string, index: number) =>
            <li key={index}>
              <a
                key={index}
                href={`#${item}`}
                className="footer__link">{item}</a>
            </li>
          )}
        </ul>

        <div className="foooter__social">
        </div>
      </div>
    </footer>
  )
}
