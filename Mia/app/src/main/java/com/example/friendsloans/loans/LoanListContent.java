package com.example.friendsloans.loans;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.friendsloans.contacts.ContactListContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class LoanListContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Loan> ITEMS = new ArrayList<Loan>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Loan> ITEM_MAP = new HashMap<String, Loan>();

    private static final int COUNT = 0;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    public static void addItem(Loan item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Loan createDummyItem(int position) {
        return new Loan(String.valueOf(position), new ContactListContent.Contact(), makeDetails(position), "10");
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }


    public static class Loan implements Parcelable {
        public final String id;
        public final ContactListContent.Contact contact;
        public final String details;
        public final String amount;

        public Loan(String id, ContactListContent.Contact content, String details, String amount) {
            this.id = id;
            this.contact = content;
            this.details = details;
            this.amount = amount;
        }
        protected Loan(Parcel in) {
            id = in.readString();
            String c1 = in.readString();
            String c2 = in.readString();
            String c3 = in.readString();
            String c4=  in.readString();
            contact = new ContactListContent.Contact(c1,c2,c3,c4);
            details = in.readString();
            amount = in.readString();
        }

        public String getId()
        {
            return id;
        }

        public static final Creator<Loan> CREATOR = new Creator<Loan>() {
            @Override
            public Loan createFromParcel(Parcel in) {
                return new Loan(in);
            }

            @Override
            public Loan[] newArray(int size) {
                return new Loan[size];
            }
        };


        @Override
        public String toString() {
            return id;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(contact.id);
            dest.writeString(contact.name);
            dest.writeString(contact.phone);
            dest.writeString(contact.email);
            dest.writeString(details);
            dest.writeString(amount);

        }
    }
}