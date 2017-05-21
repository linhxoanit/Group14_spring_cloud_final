<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:icsse>
	<jsp:body>

	<form>
            <textarea name="editor1" id="editor1" rows="10" cols="80">
                
            </textarea>
            <button id="btnsave" >Save</button>
    </form>
    
    <script>
    	CKEDITOR.replace('editor1');
    	var text = '${text}';
    	var editor = CKEDITOR.instances['editor1'];
    	editor.setData(text);  
    	
    	
    	$('#btnsave').click(function(e){
        	e.preventDefault();
        	$.post('/upload',{
        		noidung: $(CKEDITOR.instances['editor1'].getData()).text()
        		
        	}).done(function (result){
        		alert(result);
        		location.reload;
        	}).fail(function(){
        		alert("error");
        	});
    	});
    </script>
    
   </jsp:body>
</t:icsse>