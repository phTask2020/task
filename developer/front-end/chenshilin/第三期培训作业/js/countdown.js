function showDate(){
    // 设置活动结束时间
    var dateStr = "2020-04-11 22:35:00";
    // 转换为时间
    var endDate = new Date(timeStr)
    // 获取系统当前时间
    var nowDate = new Date();
    // 获取活动剩余时间的毫秒值
    var ms = endDate - nowDate;
    // 转换成天数
    var days = parseInt(ms/1000/60/60/24,10);
    // 转换成小时
    var hours = parseInt(ms/1000/60/60%24,10);
    // 转换成分钟
    var minutes = parseInt(ms/1000/60%60,10);
    // 转换成秒钟
    var seconds = parseInt(ms/1000%60,10);

    // 在0-9的数前加上0
    // days = checkTime(days);
    // hours = checkTime(hours);
    // minutes = checkTime(minutes);
    // seconds = checkTime(seconds);

    //在页面上显示
    document.getElementById(hour).innerHTML = hours; 
    document.getElementById(minute).innerHTML = minutes;
    document.getElementById(second).innerHTML = seconds;
}
// 每隔一秒调用一次函数
window.onload = function(){
    window.setTimeout("showDate",1000);
}
    