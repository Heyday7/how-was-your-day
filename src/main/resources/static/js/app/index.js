var main = {
    init : function () {
        var _this = this;

        $('#btn-save').on('click', function() {
            _this.save();
        });

        $('#btn-action-add').on('click', function() {
            var html = `<p><input name="action[][comment]" type="text">
                        <select name="action[][type]">
                            <option value="Work">Work</option>
                            <option value="Study">Study</option>
                            <option value="Exercise">Exercise</option>
                            <option value="Hobby">Hobby</option>
                            <option value="Any">Any</option>
                        </select>
                        <button type="button" id="btn-action-delete">삭제</button></p>`
            $('#action-list').append(html);
        });
        $(document).ready(function () {
            $(document).on('click', "button[id='btn-action-delete']" ,function() {
                $(this).parent().remove();
            });
        });
    },

    save : function () {

        var actionCnt = $('input[name="comment[]"]').length;
        var actions = new Array(actionCnt);
        for (var i =0; i < actionCnt; i++) {
            var action = {
                comment: $('input[name="comment[]"]')[i].value,
                type: $('select[name="type[]"]')[i].value
            }
            actions[i] = action
        };

        var data = {
            title: $('#title').val(),
            body: $('#body').val(),
            actions: actions,
            isPrivate: $('#is-private').is(":checked")
        };

        $.ajax({
            type: 'POST',
            url: '/api/diaries',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('Diary가 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    },
};


main.init();