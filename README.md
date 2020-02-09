# NotesApp
Android application to take notes.

Below are the layer of this application

1. Data

  This includes interation with Database.

2. Domain

  Contains business logic of the application. The POJO classes are defined in this layer.

3. Usecases
  
   Sometimes called interactors. Defines actions the user can trigger.

4. Presentation

   This includes the UI, Presenter, and ViewModels. This is the layer that interacts with UI.

The application supports below functionalities

1. Add new note
2. Edit existing note
3. Display list of notes
4. Sorting list of note by timestamp. The latest note will be displayed at the top

