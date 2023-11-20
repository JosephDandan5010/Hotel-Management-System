
function confirmRoomDelete(roomId) {
    var result = confirm('Are you sure you want to delete this room?');
    if (result) {
        // If the user confirms, submit the form
        document.getElementById('deleteForm-' + roomId).submit();
    }
    else {
            console.log('Delete canceled. No action taken.'); //LOGS TO CONSOLE ONCE CANCELED
        }
}
