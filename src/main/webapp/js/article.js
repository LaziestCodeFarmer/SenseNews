window.onload=function (){
    document.getElementById("collect").onclick = function () {
        if(document.getElementById("collect").innerText=="收藏"){
            collect();
        }
        if(document.getElementById("collect").innerText=="已收藏"){
            backCollect();
        }
    };
    function collect() {
        //获取uId和aId
        var uId = document.getElementById("uId").innerText;
        var aId = document.getElementById("aId").innerText;
        //创建异步请求对象
        var ajax = new XMLHttpRequest();
        //设置请求类型，url,参数
        ajax.open("get", "./collected?uId="+uId+"&aId="+aId);
        //发送请求
        ajax.send();
        //ajax状态改变时，执行的函数
        ajax.onreadystatechange = function () {
            if (ajax.readyState == 4 && ajax.status == 200) {
                //200表示请求成功，修改收藏为已收藏和修改id
                document.getElementById("collect").innerText="已收藏";
                //修改收藏次数
                var sum = document.getElementById("collectSum");
                if(sum.innerText==""){
                    sum.innerText=0;
                }
                sum.innerText = parseInt(sum.innerText,10)+1;
            }
        }
    }

    function backCollect() {
        //获取uId和aId
        var uId = document.getElementById("uId").innerText;
        var aId = document.getElementById("aId").innerText;
        //创建异步请求对象
        var ajax = new XMLHttpRequest();
        //设置请求类型，url,参数
        ajax.open("get", "./backCollect?uId="+uId+"&aId="+aId);
        //发送请求
        ajax.send();
        //ajax状态改变时，执行的函数
        ajax.onreadystatechange = function () {
            if (ajax.readyState == 4 && ajax.status == 200) {
                //200表示请求成功，修改收藏为已收藏和修改id
                document.getElementById("collect").innerText="收藏";
                //修改收藏次数
                var sum = document.getElementById("collectSum");
                sum.innerText = parseInt(sum.innerText,10)-1;
            }
        }
    }
}