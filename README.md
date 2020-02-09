# NotesApp
Android application to take notes.

Below are the layer of this application

1. Data

    This includes interation with Database. Room library is being used to perform DB operations.
    Repository pattern is used in this layer to store and access data from database.

2. Domain

    Contains business logic of the application. The POJO classes are defined in this layer.
    Note class has been defined which implements parcelable to pass instance between activities.

3. Usecases
  
    This layer converts and passes user actions, also known as use cases, to inner layers of the application.
    The usecases supported in this application are AddNote, GetNotes and UpdateNote

4. Presentation

    This includes the UI, Presenter, and ViewModels. This is the layer that interacts with UI.
    MVVM architecture is being followed in presentation layer.
    
    Below are the two screens displayed in the UI:
    Main Screen - Displays the list of notes which has been added.
                   Each view in the list displays note title and created/modified timestamp.
    Note Screen - Displayed when user selects "ADD" action button in Main screen. 
                   This activity is used for adding OR editing note. 
                   The screen has "SAVE" option which will save the note and display static content of the note.
                   
    

The application supports below functionalities

1. Add new note
2. Edit existing note
3. Display list of notes
4. Sorting list of note by timestamp. The latest note will be displayed at the top



