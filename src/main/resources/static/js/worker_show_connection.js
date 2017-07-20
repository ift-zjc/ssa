/*
This javascript is worker that used for show different connections between base station and satellite
 */

self.onmessage = function(msg){

    msg.data.ecAll.show = false;
    msg.data.ecOpt.show = false;

    switch(msg.data.show){
        case 'all':
            msg.data.ecAll.show = true;
            break;


        case 'optimized':
            msg.data.ecOpt.show = true;
            break;

        default:
            throw ' No option provided, all/optimize';
    }
}