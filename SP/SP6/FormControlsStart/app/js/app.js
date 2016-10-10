var myApp = angular.module('DemoApp',[]);

myApp.controller('FeedbackController', ['$scope', function($scope) {
  var feedback={};
  $scope.locations = ["New York","Vancouver","Atlantis","Blackpool","Copenhagen"];
  $scope.satisfactionValues = ["Very satisfied","Satisfied","Didn't care","Dissatisfied","Very dissatisfied"];
  $scope.emotions = ["Angry","Sad","Happy","Ambivalent"];

  $scope.feedback = {};
  $scope.feedback.name;
  $scope.feedback.gender;
  $scope.feedback.email;
  $scope.feedback.location;
  $scope.feedback.comments;
  $scope.feedback.satisfactionValue;
  $scope.feedback.selectedEmotions = [];//['Happy'];

}]);