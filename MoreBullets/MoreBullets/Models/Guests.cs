using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.ComponentModel;
namespace MoreBullets.Models
{
    public class Guests : INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler? PropertyChanged;
        public void OnPropoertyChanged(string propoertyName)
        {
            if (PropertyChanged != null)
                PropertyChanged(this, new PropertyChangedEventArgs(propoertyName));
        }

        private string name;
        public string Name
        {
            get { return name; }
            set { name = value; OnPropoertyChanged("Name"); }
        }

        private int contact;
        public int Contact
        {
            get { return contact; }
            set { contact = value; OnPropoertyChanged("Contact"); }
        }

        private int stay;
        public int Stay
        {
            get { return stay; }
            set { stay = value; OnPropoertyChanged("Stay"); }
        }

        private int party;
        public int Party
        {
            get { return party; }
            set { party = value; OnPropoertyChanged("Party"); }
        }

        private int room;
        public int Room
        {
            get { return room; }
            set { room = value; OnPropoertyChanged("Room"); }
        }
    }
}
