/*
This javascript is worker that used for show different connections between base station and satellite
 */

importScripts('/js/underscore-min.js');

self.onmessage = function(msg){

    throw 'Start';
    
    switch(msg.data.show){
        case 'all':
            var processed = 0;
            var total = msg.data.allIds.length;
            _.each(msg.data.allIds, function(id){
                postMessage({id: id, progress: processed, total: total});
                processed++;
            });
            break;


        case 'optimized':
            var processed = 0;
            var total = msg.data.allIds.length;
            _.each(msg.data.allIds, function(id){
                postMessage({id: id, progress: processed, total: total});
                processed++;
            });
            break;

        default:
            throw ' No option provided, all/optimize';
    }
}