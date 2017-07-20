/*
This javascript is worker that used for show different connections between base station and satellite
 */

importScripts('/js/underscore-min.js');

self.onmessage = function(msg){


    switch(msg.data.show){
        case 'all':

            _.each(msg.data.optIds, function(id){
                postMessage({id: id, show:false});
            });

            var processed = 0;
            var total = msg.data.allIds.length;
            _.each(msg.data.allIds, function(id){
                postMessage({id: id, progress: ++processed, total: total});
            });
            break;


        case 'optimized':

            // disable all
            _.each(msg.data.allIds, function(id){
                postMessage({id: id, show: false});
            });
            var processed = 0;
            var total = msg.data.optIds.length;
            _.each(msg.data.optIds, function(id){
                postMessage({id: id, progress: ++processed, total: total});
            });
            break;

        default:
            throw ' No option provided, all/optimize';
    }
}