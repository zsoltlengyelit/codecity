var configuration = {
    'routes' : [

    {
        path : '/home',
        forward : '/index/index'
    }, {
        path : '/signin',
        forward : '/index/login'
    },

    ],

    'view.basePath' : '/WEB-INF/view'
    
};