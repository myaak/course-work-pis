interface GenreItem {
  genreName: string
}

export default function GenreItem({ genreName }: GenreItem) {
  return (
    <div className="genre-item__container">
      {genreName}
    </div>
  )
}
