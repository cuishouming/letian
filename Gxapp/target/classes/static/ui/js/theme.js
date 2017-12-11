//风格的切换



var saveSelectColor = {
    'Name': 'SelcetColor',
    'Color': 'theme-black'
}



// 判断用户是否已有自己选择的模板风格
if (storageLoad('SelcetColor')) {
    $('body').attr('class', storageLoad('SelcetColor').Color)
} else {
    storageSave(saveSelectColor);
    $('body').attr('class', 'theme-black')
}
/**
 * 在HTML5中，新加入了一个localStorage特性，这个特性主要是用来作为本地存储来使用的，
 * 解决了cookie存储空间不足的问题(cookie中每条cookie的存储空间为4k)，
 * localStorage中一般浏览器支持的是5M大小，这个在不同的浏览器中localStorage会有所不同。
 */

// 本地缓存
function storageSave(objectData) {
	console.log(objectData)
    localStorage.setItem(objectData.Name, JSON.stringify(objectData));//JSON.stringify()这个方法，来将JSON转换成为JSON字符串
											
}

function storageLoad(objectName) {
    if (localStorage.getItem(objectName)) {
        return JSON.parse(localStorage.getItem(objectName))//读取之后要将JSON字符串转换成为JSON对象，使用JSON.parse()方法
    } else {
        return false
    }
}