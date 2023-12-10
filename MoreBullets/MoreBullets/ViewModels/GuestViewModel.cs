using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.ComponentModel;
using MoreBullets.Models;
using MoreBullets.Commands;
using MoreBullets.ViewModels;
using System.Collections.ObjectModel;

namespace MoreBullets.ViewModels
{
    public class GuestViewModel : INotifyPropertyChanged
    {
        #region INotifyPropertyChanged_Implementation
        public event PropertyChangedEventHandler PropertyChanged;
        private void OnPropertyChanged(string propertyName)
        {
            if (PropertyChanged != null)
            {
                PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
            }
        }
        #endregion



        GuestService ObjGuestService;
        public GuestViewModel()
        {
            ObjGuestService = new GuestService();
            LoadData();
            CurrentGuest = new Guests();
            saveCommand = new RelayCommand(Save);
            searchCommand = new RelayCommand(Search);
            updateCommand = new RelayCommand(Update);
            deleteCommand = new RelayCommand(Delete);
        }

        #region Display Operation
        private ObservableCollection<Guests> guestsList;
        public ObservableCollection<Guests> GuestsList
        {
            get { return guestsList; }
            set { guestsList = value; OnPropertyChanged("GuestsList"); }
        }
        private void LoadData()
        {
            GuestsList = new ObservableCollection<Guests>(ObjGuestService.GetAll());
        }
        #endregion

        private Guests currentGuest;

        public Guests CurrentGuest
        {
            get { return currentGuest; }
            set { currentGuest = value; OnPropertyChanged("CurrentGuest"); }
        }
        private string message;

        public string Message
        {
            get { return message; }
            set { message = value; OnPropertyChanged("Message"); }
        }

        #region Saved Operation
        private RelayCommand saveCommand;

        public RelayCommand SaveCommand
        {
            get { return saveCommand; }
        }
        public void Save()
        {
            try
            {
                var IsSaved = ObjGuestService.Add(currentGuest);
                LoadData();
                CurrentGuest = new Guests();
                if (IsSaved)
                {
                    Message = "Guest saved";
                }
                else
                {
                    Message = "Saved operation failed";
                }

            }
            catch (Exception ex)
            {
                Message = ex.Message;
            }
        }
        #endregion

        #region Search Operation
        private RelayCommand searchCommand;
        public RelayCommand SearchCommand
        {
            get { return searchCommand; }
        }
        public void Search()
        {
            try
            {
                var ObjGuests = ObjGuestService.Search(CurrentGuest.Room);
                if (ObjGuests != null)
                {
                    CurrentGuest.Name = ObjGuests.Name;
                    CurrentGuest.Contact = ObjGuests.Contact;
                    CurrentGuest.Stay = ObjGuests.Stay;
                    CurrentGuest.Party = ObjGuests.Party;
                    Message = "Guest Found";

                }
                else
                {
                    Message = "Guest not Found";
                }
            }
            catch (Exception ex)
            {

            }
        }
        #endregion

        #region Update Operation
        private RelayCommand updateCommand;
        public RelayCommand UpdateCommand
        {
            get { return updateCommand; }
        }
        public void Update()
        {
            try
            {
                var IsUpdated = ObjGuestService.Update(CurrentGuest);
                if (IsUpdated)
                {
                    Message = "Guest Data Updated";
                    LoadData();
                }
                else
                {
                    Message = "Update Failed";
                }
            }
            catch (Exception ex)
            {
                Message = ex.Message;
            }
        }
        #endregion

        #region Delete Operation
        private RelayCommand deleteCommand;
        public RelayCommand DeleteCommand
        {
            get { return deleteCommand; }
        }
        public void Delete()
        {
            try
            {
                var IsDelete = ObjGuestService.Delete(CurrentGuest.Room);
                if (IsDelete)
                {
                    Message = "Guest Deleted";
                    LoadData();
                }
                else
                {
                    Message = "Deletetion Failed";
                }
            }
            catch (Exception ex)
            {
                Message = ex.Message;
            }
        }
        #endregion
    }
}
