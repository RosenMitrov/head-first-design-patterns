package pull;

interface IObserver {

    //When called this method the Observer will pull the needed data,
    // from its Subject.
    void update();
}
