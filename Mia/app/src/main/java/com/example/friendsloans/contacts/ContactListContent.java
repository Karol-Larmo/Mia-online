package com.example.friendsloans.contacts;

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
public class ContactListContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Contact> ITEMS = new ArrayList<Contact>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Contact> ITEM_MAP = new HashMap<String, Contact>();

    private static final int COUNT = 1;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    public static void addItem(Contact item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Contact createDummyItem(int position) {
        return new Contact(String.valueOf(position), "test", "000000000", "test@gmail.com");
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class Contact {
        public final String id;
        public final String name;
        public final String phone;
        public final String email;

        public Contact(String id, String name, String phone, String email) {
            this.id = id;
            this.name = name;
            this.phone = phone;
            this.email = email;

        }

        @Override
        public String toString() {
            return name;
        }
    }
}