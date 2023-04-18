console.log("Hello form JS file")

var cSharpAPI = 'https://localhost:7001/api/Animal'





// async function getCSharp() {
//     var response = await fetch('https://localhost:7001/api/Animal', { mode: 'no-cors' })
//     // var data = await response.json()
//     console.log("full C# api data:", response)
// }
// getCSharp()

function getCSharp() {
    fetch('https://localhost:7001/api/Animal')
    .then(response => response.json())
    .then(data => {
        console.log(data)
    })
    .catch(error => {
        console.log("error", error)
    })
}