
function showDate (){
    // 设置活动结束时间
    var dateStr = "2020-04-12 15:32:00";
    // 转换为时间
    var endDate = new Date(dateStr)
    // 获取系统当前时间
    var nowDate = new Date();
    // 获取活动剩余时间的毫秒值
    var ms = endDate - nowDate;
    // 转换成天数
    var days = parseInt(ms/1000/60/60/24,10);
    // 转换成小时
    var hours = parseInt(ms/1000/60/60 % 24,10);
    // 转换成分钟
    var minutes = parseInt(ms/1000/60 % 60,10);
    // 转换成秒钟
    var seconds = parseInt(ms/1000 % 60,10);

    //在页面上显示
    if (hours>=10) {
        document.getElementById("hour").innerHTML = hours; 
    } else if(hours<10 && hours>=0){
        document.getElementById("hour").innerHTML = "0" + hours;
    }else{
        // 活动结束后显示00
        document.getElementById("hour").innerHTML = "00";
    };
    if (minutes>=10) {
        document.getElementById("minute").innerHTML = minutes;
    } else if(minutes<10 && minutes>=0){
        document.getElementById("minute").innerHTML = "0" + minutes;
    }else{
        document.getElementById("minute").innerHTML = "00";
    };
    if (seconds>=10) {
        document.getElementById("second").innerHTML = seconds;
    } else if (seconds<10 && seconds>=0) {
        document.getElementById("second").innerHTML = "0" + seconds;
    }else{
        document.getElementById("second").innerHTML = "00";
    }  
    // 递归调用函数
    window.setTimeout("showDate()",1000);
}
// 页面加载完调用
window.onload = function(){
    showDate();  
}
    