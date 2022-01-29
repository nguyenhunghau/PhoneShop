var formatNumber = function(number) {
    return String(number).replace(/(.)(?=(\d{3})+$)/g,'$1,');
}