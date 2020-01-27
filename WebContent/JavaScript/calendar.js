 $.ajax({
     type : "POST",
     url : "TbCal.do?command=dday&year="+year+"&month="+month+"&date"+date,
     dataType: "json", 
     success : function(data) {
         $('#reply').empty();
         $.each(data, function(key, val){
             console.log('key:' + key + ' / ' + 'value:' + val['reply']);
             $('#reply').append(val['reply']+'<br>');
         });
     },
     error : function(request,status,error) {  
        alert("code:"+request.status+"\n"+"error:"+error);
     }
  });