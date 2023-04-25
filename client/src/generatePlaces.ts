export const generatePlaces = (places: any) => {
  console.log(places.length)
  let modifiedPlaces: any = []
  let count = 0
  let rowPlaces: any = []
  for (let i = 0; i < places.length + 1; ++i) {

    if (count === 5) {

      const placesObject = {
        row: modifiedPlaces.length === 0 ? 1 : modifiedPlaces[modifiedPlaces.length - 1].row + 1,
        rowPlaces: rowPlaces
      }

      modifiedPlaces.push(placesObject)
      count = 0
      rowPlaces = []

    }

    rowPlaces.push(places[i])

    count++
  }

  return modifiedPlaces
}
