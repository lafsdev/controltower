$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event){
    var button = $(event.relatedTarget);
    var codigoRota = button.data('id');
    var descricaoRota =  button.data('origem') + ' -> '  + button.data('destino');;
    var modal = $(this);
    var form = modal.find('form');
    var action = form.data('url-base');
    if(!action.endsWith('/')){
        action += '/';
    }
    form.attr('action', action + codigoRota);

    modal.find('.modal-body span').html('Tem certeza que deseja excluir a Rota <strong>' + descricaoRota + '</strong>?')

})

$(function(){
    $('[rel="tooltip"]').tooltip();
});