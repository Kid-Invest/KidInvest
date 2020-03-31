const url = new URL(
    "https://api.worldtradingdata.com/api/v1/stock"
);

let params = {
    "symbol": "SNAP,TWTR,VOD.L",
    "api_token": "d6PTrQRT1GGzuevKIczQxeFHLKLh6VSSztliEAAAUgC70AjjvhREy2xwqqKe",
};
Object.keys(params)
    .forEach(key => url.searchParams.append(key, params[key]));

fetch(url, {
    method: "GET",
})
    .then(response => response.json())
    .then(json => console.log(json));