(function() {
    'use strict';

    angular
        .module('app')
        .controller('BookingsController', BookingsController);

    BookingsController.$inject = ['$http'];

    function BookingsController($http) {

        var vm = this;
        vm.bookings = [];
        vm.getAll = getAll;
        vm.getAffordable = getAffordable;
        vm.deleteBooking = deleteBooking;
        vm.save = save;
        vm.updateHotel = updateHotel;
        vm.update = update;
        
        vm.hotelInfo = {
        		"id":-1,
        		"hotelName" : "",
    			"pricePerNight":0,
    			"nbOfNights":0
        }

        init();

        function init() {
            getAll();
        }

        function getAll() {
            var url = '/bookings/hotel';
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response) {
                vm.bookings = response.data;
            });
        }

        function getAffordable() {
            var url = '/bookings/affordable/' + 100;
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response) {
                vm.bookings = response.data;
            });
        }

        function deleteBooking(id) {
            var url = '/bookings/hotel/' + id;
            $http.delete(url).then(function(response) {
                vm.bookings = response.data;
            });
        }
        
        function save(data) {
            var url = '/bookings/hotel/';
            $http.post(url , data).then(function(response) {
                vm.bookings = response.data;
            });
        }
        
        function update(data) {
            var url = '/bookings/hotel/';
            $http.put(url , data).then(function(response) {
                vm.bookings = response.data;
                clearForm();
            });
        }
        
        function updateHotel(data) {
        	vm.hotelInfo = angular.copy(data);
        }
        
        function clearForm() {
        	vm.hotelInfo = {
                	id: -1,
                	hotelName: "",
                	pricePerNight: 0,
                	nbOfNights: 0
            }
        }
        
        

    }

})();
