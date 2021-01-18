package APITest;


    public class Users {

        private String name;
        private String email;


        public Users() {
        }


        public void setName(String name) {
            this.name = name;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public String toString() {
            return "asd.Users{" +
                    "name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
}
