var main = {
    init : function () {
        var _this = this;

        var session_id = $("span").data("user-id");
        var writer_id = $("span").data("writer-id");
        var diary_id = $("span").data("diary-id");

        var html = `<p>
                       <button type="button" id="btn-action-update">수정</button>
                       <button type="button" id="btn-action-delete">삭제</button>
                   </p>`

        console.dir(session_id)
        console.dir(writer_id)
        if(writer_id == session_id){
            $("#edit").append(html);

            $(document).ready(function () {
                $(document).on('click', "button[id='btn-action-delete']" ,function() {
                    _this.delete()
                });
                $(document).on('click', "button[id='btn-action-update']" ,function() {
                    window.location.href = "/diary/" + diary_id + "/update"
                });
            });
        };
    },


    delete : function () {
        $.ajax({
            type: 'DELETE',
            url: '/api/diaries/' + diary_id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
        }).done(function () {
            alert('Diary가 삭제되었습니다.');
            window.location.href = '/list';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    },
};



main.init();