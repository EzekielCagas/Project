using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MoreBullets.Models
{
    public class GuestService
    {
        public static List<Guests> ObjGuestsList;

        public GuestService()
        {
            ObjGuestsList = new List<Guests>()
            {
                new Guests() {Name = "John Doe", Contact = 09999, Stay = 2, Party = 4, Room = 101}
            };
        }

        public List<Guests> GetAll()
        {
            return ObjGuestsList;
        }
        public bool Add(Guests objNewGuest)
        {
            // Party Size must be between 1 to 10 only
            if (objNewGuest.Party < 1 || objNewGuest.Party > 10)
                throw new ArgumentException("Invalid size for Party");
            // Days to stay must be betwee 1 to 5 days only
            if (objNewGuest.Stay < 1 || objNewGuest.Stay > 5)
                throw new ArgumentException("Days to stay must be only between 1 or 5 days");
            ObjGuestsList.Add(objNewGuest);
            return true;
        }

        public bool Update(Guests objGuestsToUpdate)
        {
            bool IsUpdated = false;
            for (int index = 0; index < ObjGuestsList.Count; index++)
            {
                if (ObjGuestsList[index].Room == objGuestsToUpdate.Room)
                {
                    ObjGuestsList[index].Name = objGuestsToUpdate.Name;
                    ObjGuestsList[index].Contact = objGuestsToUpdate.Contact;
                    ObjGuestsList[index].Stay = objGuestsToUpdate.Stay;
                    ObjGuestsList[index].Party = objGuestsToUpdate.Party;
                    IsUpdated = true;
                    break;
                }
            }
            return IsUpdated;
        }

        public bool Delete(int room)
        {
            bool IsDeleted = false;
            for (int index = 0; index < ObjGuestsList.Count; index++)
            {
                if (ObjGuestsList[index].Room == room)
                {
                    ObjGuestsList.RemoveAt(index);
                    IsDeleted = true;
                    break;
                }
            }
            return IsDeleted;
        }

        public Guests Search(int room)
        {
            return ObjGuestsList.FirstOrDefault(e => e.Room == room);
        }
    }
}
