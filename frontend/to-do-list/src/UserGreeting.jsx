
function UserGreeting(props){
        return(props.isLoggedIn ? <h2>Wlcome</h2>
                                : <h2>Log in first</h2>)
}
export default UserGreeting