import profilePic from './assets/profilePic.jpg'

function Card(){
    return(
        <div className="card">
            <img className='card-image' src={profilePic} alt="Profile picture"></img>
            <h2 className='card-title'>Bro Code</h2>
            <p>I make Software</p>
        </div>
    );

}

export default Card